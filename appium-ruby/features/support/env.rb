# frozen_string_literal: true

require 'rspec/expectations'
require 'appium_lib'
require 'pry'
require 'parallel'

if ENV['PLATFORM'] == 'ios'
  caps = Appium.load_appium_txt file: File.join('./ios_appium.txt')
elsif ENV['PLATFORM'] == 'android'
  caps = Appium.load_settings file: File.join('./caps_android', 'oreo.txt'), verbose: true
end

case ENV['DEVICE'] 
when 'nougat'
  caps = Appium.load_settings file: File.join('./caps_android', 'nougat.txt')
when 'oreo'
  caps = Appium.load_settings file: File.join('./caps_android', 'oreo.txt')
when 'mars'
  caps = Appium.load_settings file: File.join('./caps_android', 'mars.txt')
end


Appium::Driver.new(caps, true)
Appium.promote_appium_methods Object
